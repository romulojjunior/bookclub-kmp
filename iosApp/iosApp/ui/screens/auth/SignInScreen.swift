import SwiftUI
import shared

struct SignInScreen: View {
    @State private var viewModel = AuthViewModel(
        signInUC: AppDIKoin().signInUC
    )

    @State private var username: String = ""
    @State private var password: String = ""
    
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
            }.padding(.top, 50) 
            
            Text("Forget password").foregroundStyle(.gray).padding(30) 
        }
    }
}

struct SignInScreen_Previews: PreviewProvider {
    static var previews: some View {
        SignInScreen()
    }
}
