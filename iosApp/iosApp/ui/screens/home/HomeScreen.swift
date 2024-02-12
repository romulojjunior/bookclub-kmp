import SwiftUI
import shared

struct HomeScreen: View {
    
    init(navigateTo: @escaping (Route) -> Void) {
        self.navigateTo = navigateTo
    }
    
    private let navigateTo: (Route) -> Void
    
    var body: some View {
        TabView {
            MainTab(navigateTo: navigateTo)
                .tabItem {
                    Label("Books", systemImage: "book")
                }
            
            SearchTab(navigateTo: navigateTo)
                .tabItem {
                    Label("Search", systemImage: "magnifyingglass")
                }
        }.navigationBarBackButtonHidden(true)
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen(navigateTo: { r in })
    }
}

