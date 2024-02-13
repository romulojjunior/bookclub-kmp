import SwiftUI
import shared

struct MainTab: View {
    
    init(navigateTo: @escaping (Route) -> Void) {
        self.navigateTo = navigateTo
        self.viewModel = viewModel
        onLoad()
    }
    
    private let navigateTo: (Route) -> Void
    
    @State private var viewModel = HomeViewModel(
        searchBookByName: AppDIKoin().searchBookByNameUC,
        getFriendsByUserIdUC: AppDIKoin().getFriendsByUserIdUC
    )
    
    var body: some View {
        
        if (viewModel.exception != nil) {
            Button("Try Again") {
                onLoad()
            }
        } else if (viewModel.isLoading) {
            ProgressView()
        }
        
        
        ScrollView {
            if (!viewModel.friends.isEmpty) {
                FriendsCard(label: "Friends", friends: viewModel.friends)
            }
            
            if (!viewModel.recommendedBooks.isEmpty) {
                BooksCard(label: "Favorites", books: viewModel.favoritesBooks)
            }
            
            if (!viewModel.featuredBooks.isEmpty) {
                BooksCard(label: "Featured", books: viewModel.featuredBooks)
            }
            
            if (!viewModel.recommendedBooks.isEmpty) {
                BooksCard(label: "Recommended", books: viewModel.recommendedBooks)
            }
        }
        
    }
    
    private func onLoad() {
        viewModel.loadFavoritesBooks(name: "Travel")
        viewModel.loadFeatureBooks(name: "iOS")
        viewModel.loadRecommendedBooks(name: "Kotlin")
        viewModel.loadFriends()
    }
}

struct MainTab_Previews: PreviewProvider {
    static var previews: some View {
        MainTab(navigateTo: { r in })
    }
}

