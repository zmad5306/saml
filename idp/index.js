const {runServer} = require('saml-idp');
 
runServer({
  acsUrl: `https://localhost:7000/auth/saml20/assertion-consumer`,
  audience: `urn:example:idp`,
});