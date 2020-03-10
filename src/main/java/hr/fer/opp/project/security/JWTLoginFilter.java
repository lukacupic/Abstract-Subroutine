package hr.fer.opp.project.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
		AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);

		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(), Collections.emptyList())
		);
	}

	@Override
	protected void successfulAuthentication(
			HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain, Authentication auth) throws IOException, ServletException {
		String jwt = TokenAuthenticationService.addAuthentication(resp, auth.getName());
		addUserInfoToResponse(auth, resp, jwt);
	}

	private void addUserInfoToResponse(Authentication auth, HttpServletResponse resp, String jwt) throws IOException {
		User u = ((org.springframework.security.core.userdetails.User) auth.getPrincipal());
		String userEmail = u.getUsername();
		String userType = u.getAuthorities().toArray()[0].toString();
		String jsonResp = "{\"email\":\"" + userEmail + "\",\"userType\":\"" + userType + "\"" +
				",\"Authentication\":\"" + jwt + "\"}";

		resp.getWriter().write(jsonResp);
		resp.getWriter().flush();
	}
}