//
//  EventService.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Moya


enum EventRoute: String {
    case events
}

enum EventAPI {
    case getAll
    case getBy(_ id: String)
}

extension EventAPI : TargetType {
    
    var sampleData: Data {
        switch self {
        case .getAll, .getBy:
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
        case .getAll:
            return EventRoute.events.rawValue
        case .getBy(let id):
            return "\(EventRoute.events.rawValue)/\(id)"
        }
    }
    
    var method: Moya.Method {
        switch self {
        case .getAll, .getBy:
            return .get
        }
    }
    
    var parameterEncoding: ParameterEncoding {
        return JSONEncoding.default
    }
    
    var task: Task {
        switch self  {
        case .getAll, .getBy:
            return .requestPlain
        }
    }
}
