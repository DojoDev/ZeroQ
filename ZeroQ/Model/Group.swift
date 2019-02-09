//
//  Group.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation

struct Group: Codable {
    let name: String
    let event: Event
    let wallets: [Wallet]
}
