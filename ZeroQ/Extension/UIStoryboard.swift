//
//  UIStoryboard.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit
import Foundation

extension UIStoryboard {
    struct Storyboard {
        let name: String
        static var transaction: Storyboard { return Storyboard(name: "Transaction")}
        static var events: Storyboard { return Storyboard(name: "Event")}
        static var creditCard: Storyboard { return Storyboard(name: "CreditCard")}
        
        static var creditLimit: Storyboard { return Storyboard(name: "Credit")}
        static var group: Storyboard { return Storyboard(name: "Group")}

        
        
    
    }
    
    static func storyboard(_ storyboard: Storyboard, bundle: Bundle? = nil) -> UIStoryboard {
        return UIStoryboard(name: storyboard.name, bundle: bundle)
    }
    
    func instantiateViewController<T: UIViewController>() -> T where T: Identifiable {
        guard let viewController = self.instantiateViewController(withIdentifier: T.identifier) as? T  else {
            fatalError("Couldn’t instantiate view controller with identifier \(T.identifier)")
        }
        
        return viewController
    }
    
}
