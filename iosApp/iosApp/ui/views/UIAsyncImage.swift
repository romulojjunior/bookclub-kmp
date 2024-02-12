import SwiftUI


struct UIAsyncImage: View {
    
    init(url: String) {
        self.url = url
    }
    
    private let url: String
    
    var body: some View {
        AsyncImage(url: URL(string: url)) { phase in
            switch phase {
            case .success(let image):
                image.resizable()
                     .aspectRatio(contentMode: .fit)
                     .frame(width: 120, height: 180)
            @unknown default:
                EmptyView()
            }
        }
    }
}

