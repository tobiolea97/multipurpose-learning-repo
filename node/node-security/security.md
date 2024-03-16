### Owasp

Page to learn how to build secure webapps https://nodegoat-websec.herokuapp.com/tutorial

### Tips

- Validate and sanitize data in order to prevent CSS (cross site scripting), denial of service or server side injection
- Maintain package dependencies (use audit and outdated)
- Add a two factor and read only tokens on npmjs (packages repository)
- Use type and validation on mongoose models
- Use prepared statements (mongoose or Sequelize)
- Set proper http headers with Gelmet
- Encrip user data an session with Crypto
- Use sessionStorage over localStorage
- Use https
- Rate limiting against DoS attack (express-rate-limit module)
- Use CSURF to prevent CSRF attacks
- Use cookie attributes
- Use OWASp Dependency check
- Find vulnerabilities with Snyk
- Penetration testing with Burp
