//
//  Confiuration.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import IQKeyboardManagerSwift

struct Configuration {

    func setup() {
        configureKeyboard()
        configureNavigation()
    }
    
    private func configureKeyboard() {
        IQKeyboardManager.shared.enable = true
        IQKeyboardManager.shared.shouldResignOnTouchOutside = true
    }
    
    private func configureNavigation() {
        UINavigationBar.appearance().setBackgroundImage(UIImage(), for: .default)
        // Sets shadow (line below the bar) to a blank image
        UINavigationBar.appearance().shadowImage = UIImage()
        // Sets the translucent background color
        UINavigationBar.appearance().backgroundColor = .clear
        // Set translucent. (Default value is already true, so this can be removed if desired.)
        UINavigationBar.appearance().isTranslucent = true
        let attributes = [NSAttributedString.Key.font: UIFont(name: "Montserrat-Medium", size: 17)!]
        UINavigationBar.appearance().titleTextAttributes = attributes
    }
}
