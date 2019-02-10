//
//  ZeroQTests.swift
//  ZeroQTests
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import XCTest
@testable import ZeroQ

class ZeroQTests: XCTestCase {

    override func setUp() {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testExample() {
        EventService().getAll(completion: { response in
            switch response {
            case .success(let event):
                print("event \(event)")
            case .failure(let error):
                print(error)
            }
            print(response)
        })
    }

    func testPerformanceExample() {
        // This is an example of a performance test case.
        self.measure {
            // Put the code you want to measure the time of here.
        }
    }

}