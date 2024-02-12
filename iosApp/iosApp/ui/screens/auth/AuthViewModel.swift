
import shared

@Observable
class AuthViewModel : IAuthViewModel {
    
    init(signInUC: ISignInUC) {
        self.signInUC = signInUC
        self.session = nil
        self.exception = nil
        self.isLoading = false
    }
    
    var session: Session?
    var exception: Any?
    var isLoading: Bool
    
    let signInUC: ISignInUC
        
    func signIn(username: String, password: String) {
        isLoading = true
        signInUC.execute(username: username, password: password) { session, error in
            self.isLoading = false
            if (error != nil) {
                self.session = nil
                self.exception = error
            } else {
                self.exception = nil
                self.session = session
            }
        }
    }
}
