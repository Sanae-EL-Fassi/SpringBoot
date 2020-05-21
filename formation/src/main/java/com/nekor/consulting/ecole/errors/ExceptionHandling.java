package com.nekor.consulting.ecole.errors;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.DefaultProblem;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;
import org.zalando.problem.violations.ConstraintViolationProblem;

import com.nekor.consulting.ecole.exceptions.MyException;

@ControllerAdvice
public class ExceptionHandling implements ProblemHandling, SecurityAdviceTrait {
	private static final String FIELD_ERRORS_KEY = "fieldErrors";
	private static final String MESSAGE_KEY = "message";
	private static final String PATH_KEY = "path";
	private static final String VIOLATIONS_KEY = "violations";

	@Override
	// A problem is an abstraction f any error we want to inform about(it contains
	// handy informations about the error)
	public ResponseEntity<Problem> process(ResponseEntity<Problem> entity, NativeWebRequest request) {
		if (entity == null) {
			return entity;
		}

		Problem problem = entity.getBody();

		if (!(problem instanceof ConstraintViolationProblem || problem instanceof DefaultProblem)) {
			return entity;
		}
		// We will custom Problem object that adapt to our needs
		ProblemBuilder builder = Problem.builder()
				.withType(Problem.DEFAULT_TYPE.equals(problem.getType()) ? Problem.DEFAULT_TYPE : problem.getType())
				.withStatus(problem.getStatus()).withTitle(problem.getTitle())
				.with(PATH_KEY, request.getNativeRequest(HttpServletRequest.class).getRequestURI());

		if (problem instanceof ConstraintViolationProblem) {
			builder // a problem that indicate a syntactically correct yet semantically illegal
					// request
					.with(VIOLATIONS_KEY, ((ConstraintViolationProblem) problem).getViolations())
					.with(MESSAGE_KEY, URI.create("ErrorConstants.ERR_VALIDATION"));
		} else {
			builder.withCause(((DefaultProblem) problem).getCause()).withDetail(problem.getDetail())
					.withInstance(problem.getInstance());
			problem.getParameters().forEach(builder::with);
			if (!problem.getParameters().containsKey(MESSAGE_KEY) && problem.getStatus() != null) {
				builder.with(MESSAGE_KEY, "error.http." + problem.getStatus().getStatusCode());
			}
		}
		return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());

	}

	@ExceptionHandler()
	public ResponseEntity<Problem> handleMyException(MyException ex, NativeWebRequest request) {
		Problem problem = Problem.builder().withStatus(Status.NOT_FOUND)
				.with(MESSAGE_KEY, "ErrorConstants.ENTITY_NOT_FOUND_TYPE").build();
		return create(ex, problem, request);
	}

	/*
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler() public ResponseEntity<Problem> handleException(Exception
	 * ex, NativeWebRequest request) { Problem problem =
	 * Problem.builder().withStatus(Status.BAD_REQUEST) .with(MESSAGE_KEY,
	 * "ErrorConstants.BAD_REQUEST").build(); return create(ex, problem, request); }
	 */

}
