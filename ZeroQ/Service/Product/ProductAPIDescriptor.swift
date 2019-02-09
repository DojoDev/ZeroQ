//
//  Product.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Moya

enum ProductAPI {
    case getAll
    case getBy(_ id: String)
    case create(name: String, price: Float)
}

extension ProductAPI : TargetType {
    
    var sampleData: Data {
        switch self {
        case .getAll, .getBy, .create:
            return "".utf8Encoded
        }
    }
    
    var headers: [String : String]? {
        // var header = Header.apiHeader
        //        let token = "Mejor \(UserInfo.shared.user!.token!)"
        //        header["Authorization"] = token
        
        return [String:String]()
    }
    
    var baseURL: URL { return URL(string: Constants.baseUrl)! }
    
    var path: String {
        switch self {
        case .getAll, .create:
            return "base"
        case .getBy(let id):
            return "base/\(id)"
        
        }
    }
    
    var method: Moya.Method {
        switch self {
        case .getAll, .getBy:
            return .get
        case .create:
            return .post
        }
    }
    
    var parameterEncoding: ParameterEncoding {
        return JSONEncoding.default
    }
    
    var task: Task {
        switch self  {
        case .getAll, .getBy, .create:
            return .requestPlain
        }
    }
}
