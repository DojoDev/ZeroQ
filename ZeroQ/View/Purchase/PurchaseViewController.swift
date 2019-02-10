//
//  PurschaseViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class PurchaseViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        tableView.dataSource = self
        tableView.register(UINib.init(nibName: "PurchaseCell", bundle: nil), forCellReuseIdentifier: "PurchaseCell")
        tableView.estimatedRowHeight = 250
        tableView.rowHeight = UITableView.automaticDimension
        tableView.backgroundColor = UIColor.clear
    }
}

extension PurchaseViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            let cell = tableView.dequeueReusableCell(withIdentifier: "PurchaseCell")! as! PurchaseCell
            return cell
    }
    
    
}
