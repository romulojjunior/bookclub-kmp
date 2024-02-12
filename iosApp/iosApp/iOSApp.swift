import SwiftUI

enum Route {
    case signin
    case home
}

@main
struct iOSApp: App {
    @State private var navigationPath = NavigationPath()
    
    var body: some Scene {
        WindowGroup {
            NavigationStack(path: $navigationPath) {
                SignInScreen(navigateTo: { r in navigationPath.append(r) })
                    .navigationDestination(for: Route.self) { route in
                        switch route {
                        case .signin: SignInScreen(navigateTo: { r in navigationPath.append(r) })
                        case .home: HomeScreen(navigateTo: { r in navigationPath.append(r)})
                            
                            
                            
                        }
                    }
            }
        }
    }
}
