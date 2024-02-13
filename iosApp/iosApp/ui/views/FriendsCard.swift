import SwiftUI
import shared

struct FriendsCard: View {
    
    init(label: String, friends: [Friend]) {
        self.label = label
        self.friends = friends
    }
    
    private let label: String
    private let friends: [Friend]
    
    var body: some View {
        HStack {
            UIPageHeader(label: label)
        }.padding(.horizontal, 16)
            .frame(maxWidth: .infinity, alignment: .leading)
        ScrollView(.horizontal) {
            LazyHStack {
                ForEach(friends, id: \.self) { friend in
                    VStack() {
                        
                        AsyncImage(url: URL(string: friend.avatarURL)) { phase in
                            switch phase {
                            case .success(let image):
                                image.resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .clipShape(Circle())
                                    .frame(width: 140, height: 120)
                            @unknown default:
                                EmptyView()
                            }
                        }
                        Text(friend.name)
                            .frame(width: 100)
                            .font(.system(size: 16))
                            .lineLimit(/*@START_MENU_TOKEN@*/2/*@END_MENU_TOKEN@*/)
                    }
                }
            }
           
        }
    }
}

struct FriendsCard_Previews: PreviewProvider {
    static var previews: some View {
        let friend = Friend(
            id: "123-mockedid",
            name: "User Name",
            avatarURL: "httpsL//mock-url"
        )
        FriendsCard(label: "Friends", friends: [friend])
    }
}

