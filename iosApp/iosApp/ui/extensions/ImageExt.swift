import SwiftUI

extension Image {
    init(path: String) {
        self.init(uiImage: UIImage(named: path)!)
    }
}
