//
//  ViewController.swift
//  MultipleView
//
//  Created by Jennifer Mah on 10/3/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
//instance of out class
    var user=Favorite()

    @IBOutlet weak var foodLabel: UILabel!
    @IBOutlet weak var chefLabel: UILabel!
    
    @IBAction func unwindSegue(_ segue:UIStoryboardSegue){
        foodLabel.text=user.favDish
        chefLabel.text=user.favChef
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
