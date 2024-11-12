# Securing Microservices

## OAuth 2.0
- register client (app or web app) with authorization server
  - client is given a **client ID** and **client Secret**
  - client is also registered with a set of **redirect URIs** (auth server uses this to send **authorization codes** and **access tokens**)
  
- End user never shares their username and password with the client application. The end user gives consent to the client application to act on its behalf
  - the authorization server issues access tokens that represent time-constrained access rights (expressed as scopes in OAuth speak)
  - the authorization server can also issue refresh tokens to the client, which could be used to obtain new access tokens when current ones expire

OAuth 2.0 defines 4 ways (**Grant Flows**) to grant client applications authorization to act on behalf of the use.
1. Authorization Code grant flow
   - user interacts with authorization server via a web browser to authenticate and give consent to client app
   - client app get an authorization code from the auth server, and uses that to exchange it [together with is client ID and client Secret] for an access token
   - then access token is then used to get access to the protected resource (in this case APIs)
   - the resource server must also validate the access token
2. Implicit grant flow
   - via a web browser, the client app gets an access token directly from the authorization server, without an authorization code.
   - this is used in cases where the client app can't securely keep a client secrect (e.g. a single-page web app)
3. Resource owner password credentials grant flow
    - the client application can't interact with a web browser. So the user must share their username and password with the application
    - client uses the user credentials to get an access token
4. Client Credentials grant flow
   - if the client application needs to call an API that's not related to any particular user, it can use it's client id and secret to obtain an access token

## OpenId Connect (OIDC)
An extension to AOth 2.0 that enables client application to **verify** the identity of end user.
- In addition to the access token, the authorization server sends back and **ID token**.
- ID token is encoded as a JSON Web Token (JWT) and digitally signed using JSON web signatures.
- So the client can trust the information in the ID by validating the signature using public keys it gets from authorization server.

OIDC defines a **discovery endpoint**:
- a standardized way to specify important endpoints. E.g. 
  - endpoint for requesting authorization codes and tokens
  - endpoint for getting public keys from authorization server to verify a digitally signed JWT.
OIDC also defines a user-info endpoint:
  - uses an access token for a user to get extra information about an authenticated user.
