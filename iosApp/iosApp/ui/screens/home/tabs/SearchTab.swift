import SwiftUI
import shared

struct SearchTab: View {
    
    init(navigateTo: @escaping (Route) -> Void) {
        self.navigateTo = navigateTo
        self.viewModel = viewModel
    }
    
    private let navigateTo: (Route) -> Void
    
    @State private var searchQuery: String = ""
    @State private var viewModel = HomeViewModel(
        searchBookByName: AppDIKoin().searchBookByNameUC,
        getFriendsByUserIdUC: AppDIKoin().getFriendsByUserIdUC
    )
    
    let columns = [
        GridItem(.adaptive(minimum: 150))
    ]
    
    var body: some View {
        VStack {
            Text("Search")
            TextField("Search", text: $searchQuery).padding(.horizontal, 36).padding(.bottom, 16).onSubmit {
                onSearch(name: searchQuery)
            }
            ScrollView {
                if (viewModel.exception != nil) {
                    Button("Try Again") {
                        onSearch(name: searchQuery)
                    }
                } else if (viewModel.isLoading) {
                    ProgressView()
                }
                if (!viewModel.searchedBooks.isEmpty) {
                    HStack {
                        Text("Result for \(searchQuery)")
                    }.padding(.horizontal, 16)
                        .frame(maxWidth: .infinity, alignment: .leading)
                    
                    LazyVGrid(columns: columns, spacing: 20) {
                        ForEach(viewModel.searchedBooks, id: \.self) { book in
                            VStack() {
                                UIAsyncImage(url: book.thumbnail ?? book.smallThumbnail ?? "")
                                Text(book.title).font(.caption).lineLimit(2)
                            }.padding(8)
                        }
                    }.padding(.horizontal, 16)
                    
                }
            }
        }
        
    }
    
    private func onSearch(name: String) {
        viewModel.searchBookByName(name: name)
    }
}

struct SearchTab_Previews: PreviewProvider {
    static var previews: some View {
        SearchTab(navigateTo: { r in })
    }
}

