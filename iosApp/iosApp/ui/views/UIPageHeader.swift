import SwiftUI


struct UIPageHeader: View {
    
    init(label: String) {
        self.label = label
    }
    
    private let label: String
    
    var body: some View {
        Text(label).font(.largeTitle)
    }
}
