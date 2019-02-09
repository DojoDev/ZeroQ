//
//  WalletService.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Result
import Moya

struct WalletService: BaseService {
    typealias Target = WalletAPI
    
    func create(data: [String: Any], price: Float, completion :  @escaping (Result<Wallet, ServiceError>)->()) {
        provider.request(.create(data)) { result in
            completion(self.handle(result: result))
        }
    }
}
