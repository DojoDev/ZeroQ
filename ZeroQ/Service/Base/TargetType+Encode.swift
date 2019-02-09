//
//  TargetType+Encode.swift
//  unycos
//
//  Created by Erick Vicente on 22/05/18.
//  Copyright © 2018 GRUPO M CONTIGO S.L. All rights reserved.
//

import Moya

extension TargetType {
    func parse<Item: Encodable>(item: Item) throws -> [String: Any] {
        let data = try JSONEncoder().encode(item)
        let dict = try JSONSerialization.jsonObject(with: data, options: .allowFragments) as? [String: Any]
        return dict ?? [String: Any]()
    }
}
