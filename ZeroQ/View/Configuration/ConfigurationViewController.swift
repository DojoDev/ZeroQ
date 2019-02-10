//
//  ConfigurationViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class ConfigurationViewController: UIViewController {

    @IBOutlet weak var subViewContainer: UIView!
    @IBOutlet weak var viewContainer: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupView()
    }

    @IBAction func openToEvents(_ sender: Any) {
        let instance = EventViewController.instance()
        self.navigationController?.pushViewController(instance, animated: true)
    }
    
    @IBAction func openToConfiguration(_ sender: Any) {
        let instance = CreditCardViewController.instance()
          self.navigationController?.pushViewController(instance, animated: true)
    }
}

extension ConfigurationViewController {
    private func setupView() {
        self.title = "CONFIGURAÇÃO"
        subViewContainer.addCornerRadius(10)
        viewContainer.addCornerRadius(10)
    }
}
