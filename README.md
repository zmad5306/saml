# Spring SAML Integration

## IDP - Identity Provider

node.js based IDP for testing

## SP - Service Provider

Spring integration with Service Provider

### Generate Certifcate (IDP)

`openssl req -newkey rsa:2048 -nodes -keyout key.pem -x509 -days 365 -out certificate.pem`

`openssl x509 -text -noout -in certificate.pem`

### Generate Key Store (SP)

`keytool -genkey -alias sp -keyalg RSA -keystore samlKeystore.jks`

`keytool -import -alias idp -file "C:\Users\Zach\Desktop\Repos\saml\idp\idp-private-key.pem" -keystore samlKeystore.jks`

## Notes

- https://github.com/vdenotaris/spring-boot-security-saml-sample/blob/master/src/main/java/com/vdenotaris/spring/boot/security/saml/web/config/WebSecurityConfig.java
- https://www.npmjs.com/package/saml-idp
- https://projects.spring.io/spring-security-saml/
