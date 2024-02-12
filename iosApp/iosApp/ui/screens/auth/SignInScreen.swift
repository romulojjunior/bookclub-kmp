import SwiftUI
import shared

struct SignInScreen: View {
    
    init(navigateTo: @escaping (Route) -> Void) {
        self.navigateTo = navigateTo
        self.viewModel = viewModel
    }
    private let navigateTo: (Route) -> Void
    
    @State private var username: String = ""
    @State private var password: String = ""
    @State private var viewModel = AuthViewModel(
        signInUC: AppDIKoin().signInUC
    )
    
    var body: some View {
        VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/) {
            Text("BookClub").font(.largeTitle).padding(.bottom, 50)
            
            TextField("Username", text: $username).padding(.horizontal, 36).padding(.bottom, 16)
            TextField("Password", text: $password).padding(.horizontal, 36)
            
            if (viewModel.isLoading) {
                ProgressView()
            }
            
            if (viewModel.exception != nil) {
                Text("Sigin error. Try again.").foregroundStyle(.red)
            }

            Button("SignIn") {
                viewModel.signIn(username: username, password:  password)
                if (viewModel.session != nil) {
                    navigateTo(Route.home)
                }
            }.padding(.top, 50)
            
            Text("Forget password").foregroundStyle(.gray).padding(30) 
        }
    }
}

struct SignInScreen_Previews: PreviewProvider {
    private let navigationPath = NavigationPath()
    
    static var previews: some View {
        SignInScreen(navigateTo: { r in })
    }
}
