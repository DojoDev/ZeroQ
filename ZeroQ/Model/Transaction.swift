//
//  Transaction.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation


struct Transaction: Codable {
    let description: String
    let value: Float
    let status: Bool
}
