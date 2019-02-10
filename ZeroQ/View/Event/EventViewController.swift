//
//  EventViewController.swift
//  ZeroQ
//
//  Created by joão victor on 09/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class EventViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    static func instance()-> EventViewController {
        return UIStoryboard.storyboard(.events).instantiateViewController() as EventViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()      
    }
}

extension EventViewController {
    private func setupView() {
        self.title = "Eventos"
        tableView.dataSource = self
        tableView.delegate = self
        tableView.register(UINib.init(nibName: "EventCell", bundle: nil), forCellReuseIdentifier: "EventCell")
        tableView.estimatedRowHeight = 300
        tableView.rowHeight = UITableView.automaticDimension
        tableView.backgroundColor = UIColor.clear
    }
}
extension EventViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "EventCell")! as! EventCell
        return cell
    }
}

extension EventViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: false)
        let instance = TransactionViewController.instance()
    self.navigationController?.pushViewController(instance, animated: true)
    }
}

extension EventViewController: Identifiable {}
