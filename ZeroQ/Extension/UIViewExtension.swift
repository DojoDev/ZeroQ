//
//  UIViewExtension.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import UIKit

extension UIView {
    func rounded() {
        self.layer.cornerRadius = self.frame.height/2
    }
    
    func addCornerRadius(_ size: CGFloat) {
        self.layer.cornerRadius = size
    }
}
