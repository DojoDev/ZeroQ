//
//  GroupService.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Result
import Moya

struct GroupService: BaseService {
    typealias Target = GroupAPI
    
    func create(data: [String: Any], price: Float, completion :  @escaping (Result<Group, ServiceError>)->()) {
        provider.request(.create(data)) { result in
            completion(self.handle(result: result))
        }
    }
}
