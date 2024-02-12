
import shared

@Observable
class HomeViewModel : IHomeViewModel {
    
    init(searchBookByName: ISearchBookByNameUC) {
        self.searchBookByName = searchBookByName
        self.featuredBooks = []
        self.recommendedBooks = []
        self.favoritesBooks = []
        self.searchedBooks = []
        self.exception = nil
        self.isLoading = false
    }
    
    var featuredBooks: [Book]
    var recommendedBooks: [Book]
    var favoritesBooks: [Book]
    var searchedBooks: [Book]
    
    var exception: Any?
    var isLoading: Bool
    
    let searchBookByName: ISearchBookByNameUC
    
    func loadFavoritesBooks(name: String) {
        isLoading = true
        searchBookByName.execute(name: name) { books, error in
            self.isLoading = false
            if (error != nil) {
                self.favoritesBooks = []
                self.exception = error
            } else {
                self.exception = nil
                self.favoritesBooks = books ?? []
            }
        }
    }
    
    func loadFeatureBooks(name: String) {
        isLoading = true
        searchBookByName.execute(name: name) { books, error in
            self.isLoading = false
            if (error != nil) {
                self.featuredBooks = []
                self.exception = error
            } else {
                self.exception = nil
                self.featuredBooks = books ?? []
            }
        }
    }
    
    func loadRecommendedBooks(name: String) {
        isLoading = true
        searchBookByName.execute(name: name) { books, error in
            self.isLoading = false
            if (error != nil) {
                self.recommendedBooks = []
                self.exception = error
            } else {
                self.exception = nil
                self.recommendedBooks = books ?? []
            }
        }
    }
    
    func searchBookByName(name: String) {
        isLoading = true
        searchedBooks = []
        searchBookByName.execute(name: name) { books, error in
            self.isLoading = false
            if (error != nil) {
                self.searchedBooks = []
                self.exception = error
            } else {
                self.exception = nil
                self.searchedBooks = books ?? []
            }
        }
    }
}
