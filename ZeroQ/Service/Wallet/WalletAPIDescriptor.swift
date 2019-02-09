//
//  WalletAPIDescriptor.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Moya

enum WalletAPI {
    case create(_ data: [String: Any])
}

extension WalletAPI : TargetType {
    
    var sampleData: Data {
        switch self {
        case .create:
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
        case .create:
            return "base"
        }
    }
    
    var method: Moya.Method {
        switch self {
        case .create:
            return .post
        }
    }
    
    var parameterEncoding: ParameterEncoding {
        return JSONEncoding.default
    }
    
    var task: Task {
        switch self  {
        case .create(let data):
            return .requestParameters(parameters: data,
                                      encoding: JSONEncoding.default)
        }
    }
}
