//
//  EventService.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import Foundation
import Result

struct EventService: BaseService {
    typealias Target = EventAPI
    

    func getBy(id: String, completion :  @escaping (Result<Event, ServiceError>)->()) {
        provider.request(.getBy(id)) { result in
            completion(self.handle(result: result))
        }
    }

    func getAll( completion :  @escaping (Result<[Event], ServiceError>)->()) {
        provider.request(.getAll) { result in
            completion(self.handle(result: result))
        }
    }
}
