//
//  ErrorResponseModel.swift
//  unycos
//
//  Created by Erick Vicente on 21/05/18.
//  Copyright © 2018 GRUPO M CONTIGO S.L. All rights reserved.
//

import Foundation

struct ResponseModel: Codable {
    
    let code: String?
    let message: String
    
    init(code: String, message: String) {
        self.code = code
        self.message = message
    }
    
}
