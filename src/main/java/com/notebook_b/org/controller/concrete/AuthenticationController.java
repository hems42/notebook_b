package com.notebook_b.org.controller.concrete;

import com.notebook_b.org.controller.abstracts.IAuthenticationController;
        import com.notebook_b.org.product.request.authenticate.LoginRequest;
        import com.notebook_b.org.product.request.authenticate.SignUpRequest;
        import com.notebook_b.org.product.request.createRequest.RoleRequestCreate;
        import com.notebook_b.org.product.response.LoginResponse;
        import com.notebook_b.org.product.response.RegistrationResponse;
        import com.notebook_b.org.product.response.SignUpResponse;
        import com.notebook_b.org.service.abstracts.IAuthenticationService;
        import com.notebook_b.org.service.abstracts.IRoleService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController implements IAuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IRoleService roleService;

    public AuthenticationController(IAuthenticationService authenticationService,
                                    IRoleService roleService) {
        this.authenticationService = authenticationService;
        this.roleService = roleService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @GetMapping("/registration")
    public RegistrationResponse confirmUser(@RequestParam String confirmToken) {

        return authenticationService.register(confirmToken);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.logIn(loginRequest));
    }


    @GetMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String refreshToken) {
        return ResponseEntity.ok(authenticationService.logOut(refreshToken));
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> addRole(@RequestBody RoleRequestCreate requestCreate) {
        return ResponseEntity.ok(roleService.addRole(requestCreate));
    }

    @PostMapping("/deneme")
    public ResponseEntity<?> deneme(@RequestParam String deneme)
    {
        return ResponseEntity.ok(authenticationService.deneme(deneme));
    }

}
