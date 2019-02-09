//
//  Parsable.swift
//  unycos
//
//  Created by Erick Vicente on 21/05/18.
//  Copyright © 2018 GRUPO M CONTIGO S.L. All rights reserved.
//

import Moya

extension Moya.Response {
    func parse<Item: Codable>() throws -> Item {
        let decoder = JSONDecoder()
        decoder.keyDecodingStrategy = .convertFromSnakeCase
        let model = try decoder.decode(Item.self, from: self.data)
        return model
    }
}

extension Encodable {
    func parseToJson() throws -> [String:Any]? {
        let data = try! JSONEncoder().encode(self)        
        return try JSONSerialization.jsonObject(with: data, options: .allowFragments) as? [String : Any]
        
    }
}

