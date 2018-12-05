package us.zacharymaddox.saml.sp.service;

import java.util.ArrayList;
import java.util.List;

import org.opensaml.xml.XMLObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Service;
import org.opensaml.xml.schema.impl.XSStringImpl;

@Service
public class SAMLUserDetailsServiceImpl implements SAMLUserDetailsService {
	
	// Logger
	private static final Logger LOG = LoggerFactory.getLogger(SAMLUserDetailsServiceImpl.class);
	
	public Object loadUserBySAML(SAMLCredential credential)
			throws UsernameNotFoundException {
		
		// The method is supposed to identify local account of user referenced by
		// data in the SAML assertion and return UserDetails object describing the user.
		
		String userID = credential.getNameID().getValue();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<XMLObject> samlRoles = credential.getAttribute("UserType").getAttributeValues();
		for (XMLObject samlRole : samlRoles) {
			if (samlRole instanceof XSStringImpl) {
				XSStringImpl str = (XSStringImpl) samlRole;
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + str.getValue().toUpperCase());
				authorities.add(authority);	
			}
			
		}
		
		LOG.info(userID + " is logged in");
		LOG.info(authorities + " are the roles");
		

		// In a real scenario, this implementation has to locate user in a arbitrary
		// dataStore based on information present in the SAMLCredential and
		// returns such a date in a form of application specific UserDetails object.
		return new User(userID, "<abc123>", true, true, true, true, authorities);
	}
	
}