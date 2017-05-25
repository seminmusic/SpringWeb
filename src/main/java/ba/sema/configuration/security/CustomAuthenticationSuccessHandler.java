package ba.sema.configuration.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	protected Log logger = LogFactory.getLog(this.getClass());
	
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
    
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
	}
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException
	{
		String targetUrl = determineTargetUrl(authentication);
		System.out.println("Target URL za trenutnog korisnika: " + targetUrl);
		
		if (response.isCommitted()) 
		{
			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication authentication)
	{
		String targetUrl = null;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities)
        {
        	String authorityName = authority.getAuthority();
        	if (authorityName.equals("ADMIN"))
			{
        		targetUrl = "/admin";
        		break;
			}
			else if (authorityName.equals("UNOS"))
			{
				targetUrl = "/banks";
				break;
			}
			else if (authorityName.equals("PREGLED"))
			{
				targetUrl = "/banks/";
				break;
			}
			else if (authorityName.equals("READ"))
			{
				targetUrl = "";
				break;
			}
        }
        
        if (targetUrl != null)
		{
        	return targetUrl;
		}
		else
		{
			throw new IllegalStateException();
		}
    }
	
	protected void clearAuthenticationAttributes(HttpServletRequest request)
	{
        HttpSession session = request.getSession(false);
        if (session == null) 
        {
        	return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
