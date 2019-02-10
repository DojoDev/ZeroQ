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
    static func instance()-> PurchaseViewController {
        return UIStoryboard.storyboard(.purchase).instantiateViewController() as PurchaseViewController
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
    }
}

extension PurchaseViewController {
    private func setupView() {
        self.title = "COMPRAR"
        tableView.dataSource = self
        tableView.delegate = self
        tableView.register(UINib.init(nibName: "PurchaseCell", bundle: nil), forCellReuseIdentifier: "PurchaseCell")
        tableView.estimatedRowHeight = 250
        tableView.rowHeight = UITableView.automaticDimension
        tableView.backgroundColor = UIColor.clear
    }
}

extension PurchaseViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: false)
        let instance = PaymentViewController.instance()
        self.navigationController?.pushViewController(instance, animated: true)
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

extension PurchaseViewController: Identifiable {}
