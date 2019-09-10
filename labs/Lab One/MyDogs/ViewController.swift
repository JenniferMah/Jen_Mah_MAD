//
//  ViewController.swift
//  MyDogs
//
//  Created by Jennifer Mah on 9/3/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var dog: UIImageView!
    @IBOutlet weak var DogText: UILabel!
    
    @IBAction func choose(_ sender: UIButton) {
        //sender is the parameter
        if sender.tag == 1{ // the tag is changed in story board
            //change image to be Randy
            dog.image = UIImage(named: "golden")
            //change text?
            DogText.text="My name is Randy and I love to snuggle!"
            
        }
        if sender.tag == 2{
            dog.image = UIImage(named: "black")
            DogText.text="My name is Boo and I love tennis balls!"

        }
        if sender.tag == 3{
            dog.image = UIImage(named: "brown")
            DogText.text="My name is Sam and I love to go on walks!"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

