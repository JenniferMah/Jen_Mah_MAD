//
//  ViewController.swift
//  Lab 3
//
//  Created by Jennifer Mah on 9/22/19.
//  Copyright © 2019 Jennifer Mah. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
//Outlets
    @IBOutlet weak var Image: UIImageView!
    @IBOutlet weak var TitleLabel: UILabel!
    @IBOutlet weak var ImageControl: UISegmentedControl!
    @IBOutlet weak var CapitolSwitch: UISwitch!
    @IBOutlet weak var ColorSwitch: UISwitch!
    @IBOutlet weak var FontSizeLabel: UILabel!
    @IBOutlet weak var CapLabel: UILabel!
    @IBOutlet weak var ColorLabel: UILabel!
    
//Actions
    func ImageChange(){
        if ImageControl.selectedSegmentIndex == 0{
            //Default image
            TitleLabel.text = "Harvest Moon"
            Image.image=UIImage(named: "HarvestMoon")
        }else if ImageControl.selectedSegmentIndex == 1{
            //Second image
            TitleLabel.text = "Blood Moon"
            Image.image=UIImage(named: "bloodMoon")
            
        }
    }
    
    func Capitalize(){
        if CapitolSwitch.isOn{
            TitleLabel.text = TitleLabel.text?.uppercased()
        }else{
            TitleLabel.text = TitleLabel.text?.lowercased()
        }
    }
    
    func DarkMode(){
        if ColorSwitch.isOn{
            self.view.backgroundColor = UIColor.black
// to help pick custom colors I used https://www.ralfebert.de/ios-examples/uikit/swift-uicolor-picker/
            let color = UIColor(red: 0/255, green: 222/255, blue: 234/255, alpha: 1.0)
            TitleLabel.textColor = color
            CapLabel.textColor = color
            ColorLabel.textColor = color
            FontSizeLabel.textColor = color

        }else{
            self.view.backgroundColor = UIColor.white
            let SecondColor = UIColor(red: 0/255, green: 28/255, blue: 158/255, alpha: 1.0)
            TitleLabel.textColor = SecondColor
            CapLabel.textColor = SecondColor
            ColorLabel.textColor = SecondColor
            FontSizeLabel.textColor = SecondColor

        }
    }
    
    @IBAction func DarkMode(_ sender: Any) {
        ImageChange()
        DarkMode()
        Capitalize()
    }
    
    
    @IBAction func Capitalization(_ sender: UISwitch) {
        ImageChange()
        DarkMode()
        Capitalize()
    }
    
    @IBAction func ImageChangeSegment(_ sender: Any) {
        ImageChange()
        DarkMode()
        Capitalize()
    }
    
    @IBAction func ChangeFontSize(_ sender: UISlider) {
        //fontSize is a float
        let fontSize = sender.value
        //write to label
        FontSizeLabel.text = String(format: "%.0f",fontSize) //convert to string the format says to ignore decimal place
        
        //Change size of font of title label
        //create UI font to change font size
        let fontSizeCGFloat = CGFloat(fontSize)
        TitleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
        
    }
    
    
}

