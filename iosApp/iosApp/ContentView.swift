import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()

	var body: some View {
		Text(greet)
        
        Text("App ios")
        Button("Test") {
            let repo: IBookRepository = AppDIKoin().bookRepository
            repo.searchByName(name: "Travalling") { result, error in
                if (error == nil) {
                    print(result!)
                }
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
