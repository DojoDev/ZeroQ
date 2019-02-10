//
//  UIButtonExtension.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import UIKit
import FontAwesome_swift
extension UIButton {
    func roundedButton(icon: FontAwesome? = nil) {
        self.rounded()
        if let icon = icon {
            self.setTitle(String.fontAwesomeIcon(name: icon), for: .normal)
        }
        self.titleLabel?.font = UIFont.fontAwesome(ofSize: 30, style: .solid)
        self.backgroundColor = UIColor.black
        self.setTitleColor(UIColor.white, for: .normal)
        
    }
}
