//
//  ProductService.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Result
import Moya

struct ProductService: BaseService {
    typealias Target = ProductAPI
    
    func create(name: String, price: Float, completion :  @escaping (Result<Product, ServiceError>)->()) {
        provider.request(.create(name: name, price: price)) { result in
            completion(self.handle(result: result))
        }
    }
    
    func getBy(id: String, completion :  @escaping (Result<Product, ServiceError>)->()) {
        provider.request(.getBy(id)) { result in
            completion(self.handle(result: result))
        }
    }
    
    
    func getAll( completion :  @escaping (Result<[Product], ServiceError>)->()) {
        provider.request(.getAll) { result in
            completion(self.handle(result: result))
        }
    }
}
