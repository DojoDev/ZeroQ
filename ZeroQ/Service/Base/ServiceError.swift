//
//  ServiceError.swift
//  unycos
//
//  Created by Erick Vicente on 21/05/18.
//  Copyright © 2018 GRUPO M CONTIGO S.L. All rights reserved.
//

import Moya
import StoreKit

enum ServiceError: Swift.Error {
    case modelMapping
    case statusCode(code: Int, response: ResponseModel)
    case unexpected
    case notConnectedToInternet
    case outOfDate
    case unauthorized
    case serviceNotFound
    case serviceException
    case tokenNotFound
    case invalidToken
    case paymentError(SKError.Code)
    case ipError
    
    static func convert(_ error: MoyaError) -> ServiceError {
        switch error {
        case .jsonMapping(_):
            return .modelMapping
            
        case let .statusCode(response):
            if response.statusCode == 401 {
                return .unauthorized
            }
            
            if response.statusCode == -1004 {
                return .outOfDate
            }
            
            if response.statusCode == 406 {
                return .invalidToken
            }
            
            if response.statusCode == NSURLErrorNotConnectedToInternet {
                return .notConnectedToInternet
            }
            
            if let model = try? response.parse() as ResponseModel {
                return .statusCode(code: response.statusCode, response: model)
            }
            
            
            return .statusCode(code: response.statusCode, response: ResponseModel(code: String(describing: response.statusCode),
                                                                                  message: (try? response.mapString()) ?? ""))
            
        case let .underlying(underlyingError):
            guard underlyingError.1?.statusCode  == NSURLErrorNotConnectedToInternet else {
                return .unexpected
            }
            
            return .notConnectedToInternet
            
        default:
            return .unexpected
        }
    }
}

