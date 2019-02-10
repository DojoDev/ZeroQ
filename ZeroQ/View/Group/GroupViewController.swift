//
//  GroupViewController.swift
//  ZeroQ
//
//  Created by joão victor on 10/02/19.
//  Copyright © 2019 hackthon movile. All rights reserved.
//

import UIKit

class GroupViewController: UIViewController {

    @IBOutlet weak var buttonAdd: UIButton!
    @IBOutlet weak var marcosImageView: UIImageView!
    @IBOutlet weak var lauraImageView: UIImageView!
    @IBOutlet weak var createGroupButton: UIButton!
    @IBOutlet weak var leftButton: UIButton!
    @IBOutlet weak var groupNameTextField: UITextField!
    
    static func instance()-> GroupViewController {
        return UIStoryboard.storyboard(.group).instantiateViewController() as GroupViewController
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        createGroupButton.addCornerRadius(25)
        leftButton.roundedButton(arrow: .arrowLeft)
        groupNameTextField.layer.cornerRadius = 10
        marcosImageView.rounded()
        lauraImageView.rounded()
        buttonAdd.rounded()
    }

    @IBAction func createGroup(_ sender: Any) {
    }
    
}

extension GroupViewController: Identifiable {}
