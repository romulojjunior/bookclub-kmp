import SwiftUI
import shared

struct BooksCard: View {
    
    init(label: String, books: [Book]) {
        self.label = label
        self.books = books
    }
    
    private let label: String
    private let books: [Book]
    
    var body: some View {
        HStack {
            UIPageHeader(label: label)
        }.padding(.horizontal, 16)
         .frame(maxWidth: .infinity, alignment: .leading)
        ScrollView(.horizontal) {
            LazyHStack {
                ForEach(books, id: \.self) { book in
                    VStack() {
                        UIAsyncImage(url: book.thumbnail ?? book.smallThumbnail ?? "")
                        Text("item \(book.title)").frame(width: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/).font(.caption).lineLimit(/*@START_MENU_TOKEN@*/2/*@END_MENU_TOKEN@*/)
                    }
                }
            }
            .padding(.horizontal, 16)
        }
    }
}
