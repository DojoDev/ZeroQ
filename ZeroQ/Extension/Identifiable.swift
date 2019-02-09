//
//  Identifiable.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import UIKit

protocol Identifiable: class { }

extension Identifiable where Self: UIView {
    
    static var identifier: String {
        return String(describing: self)
    }
    
    static var bundle: Bundle {
        return Bundle(for: self)
    }
    
}

extension Identifiable where Self: UIViewController {
    
    static var identifier: String {
        return String(describing: self)
    }
    
    static var bundle: Bundle {
        return Bundle(for: self)
    }
    
    static var nibName: String {
        return identifier
    }
}

