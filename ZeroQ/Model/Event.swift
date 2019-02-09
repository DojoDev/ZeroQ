//
//  Event.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation

struct Event: Codable {
    let name: String
    let data: String //to date
    let shopkeepers: [Shopkeeper]
}
