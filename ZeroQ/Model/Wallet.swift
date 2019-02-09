//
//  Wallet.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation

struct Wallet: Codable {
    let clientName: String
    let qrCode: String //base64
    let creditCardNumber: String
    let creditCardCVV: String
    let groups: [Group]?
    let events: [Event]?
    let transactions: [Transaction]?
    
    
}
