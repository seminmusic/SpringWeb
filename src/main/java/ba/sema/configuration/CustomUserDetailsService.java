package ba.sema.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ba.sema.entities._LoginKorisnik;
import ba.sema.entities._LoginRola;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
    private LoginService loginService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		_LoginKorisnik korisnik = loginService.findByUsername(username);
		System.out.println(korisnik);
		
		if (korisnik == null)
		{
			System.out.println("Korisnik nije pronađen");
            throw new UsernameNotFoundException("Korisničko ime nije pronađeno");
        }
		
		return new org.springframework.security.core.userdetails.User(
				korisnik.getUsername(), 
				korisnik.getPassword(), 
				korisnik.getStatus().equals("Aktivan"), 
				true, 
				true, 
				true, 
				korisnickeRole(korisnik)
		);
	}
	
	private List<GrantedAuthority> korisnickeRole(_LoginKorisnik korisnik)
	{
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
        for (_LoginRola rola : korisnik.getRoleKorisnika())
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rola.getNazivRole()));
        }
        
        System.out.println("Role korisnika: " + authorities);
        return authorities;
    }
}
